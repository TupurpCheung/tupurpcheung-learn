#!/bin/bash
#gitlab server backup to /var/opt/gitlab/backups
gitlab-rake gitlab:backup:create