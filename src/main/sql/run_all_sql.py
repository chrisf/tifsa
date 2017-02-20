""" Run sql files in correct order """
import glob
import os
import subprocess

WORKING_DIR = os.path.dirname(os.path.abspath(__file__))
FILE_LIST = glob.glob(WORKING_DIR + '/*.sql')

HOST = os.environ["MYSQL_HOST"]
USER = os.environ["MYSQL_USER"]
PASSWORD = os.environ["MYSQL_PASSWORD"]
DATABASE = os.environ["MYSQL_DATABASE"]

for sql_file_name in sorted(FILE_LIST):
    # run the sql script
    print "Executing {sql_file}".format(sql_file=sql_file_name)

    with open(sql_file_name) as in_file:
        print subprocess.check_call([
            "mysql",
            "--host=" + HOST,
            "--user=" + USER,
            "--password=" + PASSWORD,
            "--database=" + DATABASE
        ], stdin=in_file)
