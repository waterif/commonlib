TOPDIR=../../../
include ${TOPDIR}/build-scripts/Macros.mk

TARGET=all

.PHONY: all
all::
	ant dist

clean::
	ant clean

DEB_PACKAGE=confgen
DEB_VERSION=0.1.6
#DEB_MAINTAINER=
DEB_DESCRIPTION=Config generator tools.
DEB_DEPENDS=

include ${TOPDIR}/build-scripts/deb.mk

clean:: clean-deb
