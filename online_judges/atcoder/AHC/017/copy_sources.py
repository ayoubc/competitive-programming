from os.path import dirname, join, abspath
import subprocess
import re
import os
import shutil


FOLDER = abspath(dirname(__file__))


def copy_source_file():
  src = join(FOLDER, 'Solution.java')
  dst = join(FOLDER, 'ahc017', 'Solution.java')
  shutil.copyfile(src, dst)


if __name__ == '__main__':
  copy_source_file()
