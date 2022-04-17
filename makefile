DIR_ENV = 'src/env'
FILE_ENV = 'src/env/Env.java'



setup: GenerateCode

GenerateCode: GenerateFile
	@echo "package src.env; \npublic class Env { \n\tpublic static final String PasswordDB = \"mysqlpassword\"; \n}" > $(FILE_ENV)

GenerateFile: GenerateFolder
	if test -f $(FILE_ENV); then echo Env.java file already exist; else touch $(FILE_ENV); fi

GenerateFolder:
	if test -d $(DIR_ENV); then echo env folder already exist; else mkdir $(DIR_ENV); fi