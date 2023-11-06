from json import load, dump
from os.path import dirname, join, abspath
import subprocess


FOLDER = dirname(__file__)


def compile_file():
  solution = join(FOLDER, 'Solution.java')
  command = f"javac {solution}"
  p = subprocess.Popen(command, shell=True, stdout=subprocess.PIPE, stderr=subprocess.STDOUT)
  for line in p.stdout.readlines():
    l = line.decode("utf-8").strip('\n')
    print(l)
    

def get_score(line):
    a, b = line.split(' = ')
    return int(b)


def save_score(score):
    folder = dirname(__name__)
    filepath = join(folder, 'score.json')
    with open(filepath) as fp:
        d = load(fp)

    if d['score'] > score:
        with open(filepath, 'w') as fp:
            dump(dict(score=score), fp)

        print("New Record found and saved!!!")

    else:
        print("Not good !!!")


def run_tests():
    total = 0
    for i in range(100):
    
        in_file = join(FOLDER, 'in', f'{i:0>4}.txt')
        out_file = join(FOLDER, 'out', f'{i:0>4}.txt')
        tester = join(FOLDER, 'tester.exe')
        print("\nTest Case ", i)
    
        score_command = f"{tester} python solution.py < {in_file} > {out_file}"
        p = subprocess.Popen(score_command, shell=True, stdout=subprocess.PIPE, stderr=subprocess.STDOUT)
        for line in p.stdout.readlines():
            l = line.decode("utf-8").strip('\n')
            print(l)
            if 'Illegal' in l:
                raise Exception('Wrong Answer')

            if 'Cost' in l:
                total += get_score(l)

        retval = p.wait()

    print('=' * 100)
    print('Total Score = ', total)
    save_score(total)


if '__main__' == __name__:
    #compile_file()
    run_tests()
