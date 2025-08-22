#!/bin/sh

create_commit() {
  git stash pop -q stash@{"$1"}
  git add .
  git commit -q -m "$2"
}

# shellcheck disable=SC3043,SC2046,SC2155
create_current_message(){
  local MESSAGE="leetcode : "
  local NEWLY_SOLVED_QUESTIONS=$(git status --porcelain | grep -E '^A[^0-9]*[0-9]+.*$' | sed -nE 's/[^0-9]*([0-9]+).*/\1/p')
  for i in $NEWLY_SOLVED_QUESTIONS ; do
    MESSAGE="$MESSAGE$i, "
  done

  MESSAGE=$(echo "$MESSAGE" | sed 's/. $//')
  echo "$MESSAGE"
}

# shellcheck disable=SC3043,SC2046,SC2155
handle_wip_scenario(){
  # stash current
  git stash push -q
  # stash wip
  local PREVIOUS_COMMIT_ID=$(git rev-parse HEAD~1)
  git reset -q --soft "$PREVIOUS_COMMIT_ID"
  git stash push -q
  # commit current
  create_commit 1 "$1"
  # commit wip
  create_commit 0 "$2"
}

handle_normal_scenario(){
    git add .
    git commit -q -m "$1"
}

# shellcheck disable=SC3043,SC2046,SC2155
main(){
  local CURRENT_COMMIT_MSG=$(create_current_message)

  local LATEST_COMMIT_MSG=$(git log -1 --pretty=%B)
  if echo "$LATEST_COMMIT_MSG" | grep -qi "wip"; then
    handle_wip_scenario "$CURRENT_COMMIT_MSG" "$LATEST_COMMIT_MSG"
  else
    handle_normal_scenario "$CURRENT_COMMIT_MSG"
  fi

  git push -q -f
}

main