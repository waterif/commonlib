
all build build-lib build-bin clean clean-lib clean-bin:
	$(MAKE) -C src $@

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

