
TestFormGradleName ?= TestForm

TestFormTasks:
	./gradlew :$(TestFormGradleName):tasks

TestFormTasksAll:
	./gradlew :$(TestFormGradleName):tasks --all

TestFormDependencies:
	./gradlew :$(TestFormGradleName):dependencies

TestFormDependDefault:
	./gradlew :$(TestFormGradleName):dependencies --configuration default

TestFormDependCompileClasspath:
	./gradlew :$(TestFormGradleName):dependencies --configuration compileClasspath

TestFormDependentComponents:
	./gradlew :$(TestFormGradleName):dependentComponents

TestFormTest:
	./gradlew :$(TestFormGradleName):test

help-TestForm-gradle:
	@echo "=> $(TestFormGradleName)/z-gradle.mk : gradle $(TestFormGradleName) task"
	@echo "make TestFormTasks                  -> show task of $(TestFormGradleName)"
	@echo "make TestFormTasksAll               -> show all task of $(TestFormGradleName)"
	@echo "make TestFormDependencies           -> $(TestFormGradleName) full dependencies"
	@echo "make TestFormDependDefault          -> $(TestFormGradleName) dependencies of default"
	@echo "make TestFormDependCompileClasspath -> $(TestFormGradleName) dependencies of compileClasspath"
	@echo "make TestFormDependentComponents    -> $(TestFormGradleName) dependentComponents"
	@echo "make TestFormTest                   -> $(TestFormGradleName) test case"
	@echo ""