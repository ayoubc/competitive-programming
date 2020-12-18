import io
from queue import PriorityQueue
from collections import defaultdict


class Book:
    def __init__(self, title, pages):
        self.title = title
        self.pages = pages

    def __eq__(self, other):
        return self.title == other.title

    def __lt__(self, other):
        if self.title == other.title:
            return self.pages < other.pages
        return self.title < other.title

    def __str__(self):
        return f'{self.title} {self.pages}'


def split(str_):
    for i in range(len(str_) - 1, -1, -1):
        if str_[i] == ' ':
            return str_[:i], str_[i+1-len(str_):]


n, m, k = map(int, input().split())
new_books = defaultdict(list)
faovrite = '"Jane Eyre"'
pq = PriorityQueue()
pq.put(Book(faovrite, k))
for i in range(n):
    d = input()
    title, pages = split(d)
    pq.put(Book(title, int(pages)))

for i in range(m):
    time, book_info = input().split(' ', 1)
    title, pages = split(book_info)
    new_books[int(time)].append(Book(title, int(pages)))

times = list(new_books.keys())
times.sort()
t = 0
i = 0

while True:
    if i >= len(times):
        b = pq.get()
        if b.title == faovrite:
            t += k
            break
        t += b.pages
    elif t == times[i]:
        for book in new_books[times[i]]:
            pq.put(book)

        b = pq.get()
        if b.title == faovrite:
            t += k
            break

        t += b.pages
        i += 1
    elif t < times[i]:
        if pq.empty():
            t = times[i]
        else:
            b = pq.get()
            if b.title == faovrite:
                t += k
                break
            t += b.pages
    else:
        for book in new_books[times[i]]:
            pq.put(book)
        i += 1

print(t)
