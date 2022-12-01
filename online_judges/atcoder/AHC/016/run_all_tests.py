from json import load, dump
from os.path import dirname, join
import subprocess


total = 0
less_than = 0
LIMIT = 85


def get_score(line):
    a, b = line.split(' = ')
    return int(b)


def save_score(score):
    folder = dirname(__name__)
    filepath = join(folder, 'score.json')
    with open(filepath) as fp:
        d = load(fp)

    if d['score'] < score:
        with open(filepath, 'w') as fp:
            dump(dict(score=score), fp)

        print("New Record found and saved!!!")

    else:
        print("Not good !!!")


for i in range(100):
    folder = dirname(__name__)
    
    in_file = join(folder, 'in', f'{i:0>4}.txt')
    out_file = join(folder, 'out', f'{i:0>4}.txt')
    solution = join(folder, 'main.py')
    tester = join(folder, 'tester.exe')
    command = f"{tester} python {solution} < {in_file} > {out_file}"

    print("\nTest Case ", i)
    p = subprocess.Popen(command, shell=True, stdout=subprocess.PIPE, stderr=subprocess.STDOUT)
    for line in p.stdout.readlines():
        l = line.decode("utf-8").strip('\n')
        print(l)
        if 'Illegal' in l:
            raise Exception('Wrong Answer')

        if 'Score' in l:
            total += get_score(l)

        elif 'E = ' in l:
            a, b = l.split(' = ')
            if a == 'E' and int(b) <= LIMIT:
                less_than += 1

    retval = p.wait()


print('=' * 100)
print('Total Score = ', total)
print(f'Number of tests with error less than {LIMIT} = ', less_than)
save_score(total)
