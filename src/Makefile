
all: help

build: build-lib build-bin

build-lib:
	ant -f commlib/build.xml dist
	ant -f uclib/build.xml dist
	ant -f ucthrift/build.xml dist
	ant -f web/build.xml dist

build-bin: build-lib
	ant -f confgen/build.xml dist
	ant -f webframe/build.xml dist

clean: clean-bin clean-lib

clean-lib:
	ant -f commlib/build.xml clean
	ant -f uclib/build.xml clean
	ant -f ucthrift/build.xml clean
	ant -f web/build.xml clean

clean-bin:
	$(MAKE) -C confgen	clean
	ant -f webframe/build.xml clean

help:
	-@echo ""
	-@echo "	build		- build all project."
	-@echo "	build-lib	- build library project."
	-@echo "	build-bin	- build program project."
	-@echo "	clean 		- clean all project."
	-@echo "	clean-lib	- clean library project."
	-@echo "	clean-bin	- clean program project."
	-@echo "	help		- show this message."
	-@echo ""

