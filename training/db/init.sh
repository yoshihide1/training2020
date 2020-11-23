#!/bin/bash


echo -------create table--------

mysql --defaults-extra-file=root.conf < createTable.sql

echo ------- finish--------

echo -------create table--------

mysql --defaults-extra-file=root.conf < insertSampleData.sql

echo ------- finish--------
