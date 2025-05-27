build:
	make -C app build

test:
	make -C app test

report:
	make -C app report

checkstyleMain:
	make -C app checkstyleMain

sonar:
	make -C app sonar