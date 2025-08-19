#!/bin/sh

LATEST_COMMIT_MSG=$(git log -1 --pretty=%B)

if echo "$LATEST_COMMIT_MSG" | grep -qi "wip"; then
  # stash current
  git stash push -q
  # stash wip
  PREVIOUS_COMMIT_ID=$(git rev-parse HEAD~1)
  git reset -q --soft $PREVIOUS_COMMIT_ID
  git stash push -q
  # commit current
  git stash pop -q stash@{1}
  git add .
  git commit -q
  # commit wip
  git stash pop -q stash@{0}
  git add .
  git commit -q -m "$LATEST_COMMIT_MSG"
fi

git push -q -f