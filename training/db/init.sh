#!/bin/bash

mysql --defaults-extra-file=root.conf < createTable.txt
<<<<<<< HEAD
=======

echo ------- finish--------

echo -------create table--------

mysql --defaults-extra-file=root.conf --enable-local-infile < ./insert_product.txt

echo ------- finish--------
>>>>>>> e5c9356 (add database and change .sh)
