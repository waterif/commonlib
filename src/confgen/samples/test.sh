#!/bin/sh

cd `dirname $0`

for f in ./*.template
do
    d=${f%%.template}
    ../bin/confgen -d ./default.json "$f" "$d"
done
