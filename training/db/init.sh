#!/bin/bash

cd db

echo -------create table--------

mysql --defaults-extra-file=root.conf < createTable.txt

echo ------- finish--------

echo -------create table--------

mysql --defaults-extra-file=root.conf --enable-local-infile < ./insert_product.txt

echo ------- finish--------