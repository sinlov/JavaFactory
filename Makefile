.PHONY: test check clean build dist all

TOP_DIR := $(shell pwd)

# ifeq ($(FILE), $(wildcard $(FILE)))
# 	@ echo target file not found
# endif

include z-gradle-base.mk
include Utils/z-gradle.mk
include TestForm/z-gradle.mk

help: helpGradleBase help-Utils-gradle help-TestForm-gradle
	@echo "more task see makefile!"
