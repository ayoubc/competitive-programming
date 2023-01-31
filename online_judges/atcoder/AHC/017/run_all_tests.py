from json import load, dump
from os.path import dirname, join
import subprocess


total = 0
FOLDER = dirname(__name__)


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


for i in range(100):
    
    in_file = join(FOLDER, 'in', f'{i:0>4}.txt')
    out_file = join(FOLDER, 'out', f'{i:0>4}.txt')

    solution = join(FOLDER, 'Solution')
    tester = join(FOLDER, 'vis.exe')

    print("\nTest Case ", i)
    
    solution_command = f"java {solution} < {in_file} > {out_file}"
    p = subprocess.Popen(solution_command, shell=True, stdout=subprocess.PIPE, stderr=subprocess.STDOUT)
    for line in p.stdout.readlines():
        l = line.decode("utf-8").strip('\n')
        print(l)
    
    score_command = f"{tester} {in_file} {out_file}"
    p = subprocess.Popen(score_command, shell=True, stdout=subprocess.PIPE, stderr=subprocess.STDOUT)
    for line in p.stdout.readlines():
        l = line.decode("utf-8").strip('\n')
        print(l)
        if 'Illegal' in l:
            raise Exception('Wrong Answer')

        if 'Score' in l:
            total += get_score(l)

    retval = p.wait()


print('=' * 100)
print('Total Score = ', total)
save_score(total)
