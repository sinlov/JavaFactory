
UtilsGradleName ?= Utils

UtilsTasks:
	./gradlew :$(UtilsGradleName):tasks

UtilsTasksAll:
	./gradlew :$(UtilsGradleName):tasks --all

UtilsDependencies:
	./gradlew :$(UtilsGradleName):dependencies

UtilsDependDefault:
	./gradlew :$(UtilsGradleName):dependencies --configuration default

UtilsDependCompileClasspath:
	./gradlew :$(UtilsGradleName):dependencies --configuration compileClasspath

UtilsDependentComponents:
	./gradlew :$(UtilsGradleName):dependentComponents

UtilsTest:
	./gradlew :$(UtilsGradleName):test

help-Utils-gradle:
	@echo "=> $(UtilsGradleName)/z-gradle.mk : gradle $(UtilsGradleName) task"
	@echo "make UtilsTasks                  -> show task of $(UtilsGradleName)"
	@echo "make UtilsTasksAll               -> show all task of $(UtilsGradleName)"
	@echo "make UtilsDependencies           -> $(UtilsGradleName) full dependencies"
	@echo "make UtilsDependDefault          -> $(UtilsGradleName) dependencies of default"
	@echo "make UtilsDependCompileClasspath -> $(UtilsGradleName) dependencies of compileClasspath"
	@echo "make UtilsDependentComponents    -> $(UtilsGradleName) dependentComponents"
	@echo "make UtilsTest                   -> $(UtilsGradleName) test case"
	@echo ""