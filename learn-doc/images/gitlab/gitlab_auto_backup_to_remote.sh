#!/bin/bash
#local default gitlab-server backup dir,you can change it with vim /etc/gitlab/gitlab.rb ,in this file ,to find backup
LOCAL_BACK_DIR=/var/opt/gitlab/backups

#remote backup-server backup dir
REMOTE_BACK_DIR=/home/gitlab-runner/backup

#remote backup-server login account
REMOTE_USER=root

#remote backup-server ip
REMOTE_IP=47.100.xx.xxx
    
#local system date
DATE=`date +%y-%m-%d_%T`

#log save filename
LOG_FILE=$LOCAL_BACK_DIR/log/$DATE.log

#find local backup dir,time less than 60min,end with .tar backup file
BACKUP_FILE_TO_REMOTE=`find $LOCAL_BACK_DIR -type f -mmin -60 -name *.tar`

#create new log
touch $LOG_FILE

#append log to logfile
echo  "Gitlab auto backup to remote server, start at $DATE" >> $LOG_FILE

#copy to remote server
scp $BACKUP_FILE_TO_REMOTE $REMOTE_USER@$REMOTE_IP:$REMOTE_BACK_DIR
 

