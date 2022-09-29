#!/bin/sh -e

VERSION=$2
DOWNLOADED_FILE=$3
PACKAGE=$(dpkg-parsechangelog | sed -n 's/^Source: //p')
TAR=../${PACKAGE}_${VERSION}.orig.tar.gz
DIR=${PACKAGE}-${VERSION}

svn export svn://svn.freehep.org/svn/freehep/tags/$PACKAGE-$VERSION $DIR
GZIP=--best tar -c -z -f $TAR --exclude '*.jar' --exclude '*.class' $DIR
rm -rf $DIR

rm -f $DOWNLOADED_FILE

