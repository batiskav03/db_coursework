#!/bin/zsh

sudo -u postgres psql

cat sql_script.sql | sudo -u postgres psql