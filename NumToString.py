def numToString(s, original=False):
    n = int(s)
    s = str(n)
    if n == 0 and not original:
        return ""
    split = "{:,}".format(n).split(',')
    if n < 20:
        zeroNineteen = ['ZERO', 'ONE', 'TWO', 'THREE', 'FOUR', 'FIVE',
                        'SIX', 'SEVEN', 'EIGHT', 'NINE', 'TEN',
                        'ELEVEN', 'TWELVE', 'THIRTEEN', 'FOURTEEN', 'FIFTEEN',
                        'SIXTEEN', 'SEVENTEEN', 'EIGHTEEN', 'NINETEEN'
                        ]
        return zeroNineteen[n]
    elif n < 100:
        twentyNinety = ['TWENTY', 'THIRTY', 'FORTY', 'FIFTY',
                        'SIXTY', 'SEVENTY', 'EIGHTY', 'NINETY'
                        ]
        if s[1:] == "0":
            return "%s" % twentyNinety[n // 10 - 2]
        return "%s %s" % (twentyNinety[n // 10 - 2], numToString(s[1:]))
    elif n < 1000:
        if s[1:] == "00":
            return "%s HUNDRED" % numToString(s[0])
        return "%s HUNDRED %s" % (numToString(s[0]), numToString(s[1:]))
    else:
        powers = ['THOUSAND', 'MILLION', 'BILLION',
                  'TRILLION', 'QUADRILLION', 'QUINTILLION']

        return "%s %s %s" % (numToString(split[0]),
                             powers[len(split) - 2],
                             numToString("".join(split[1:]))
                             )


def search(s, visited, depth=0):
    s = "".join(numToString(s).split())
    if s in visited:
        return depth
    visited.add(s)
    n = len(s)
    return search(n, visited, depth + 1)


def __main__():
    m = 0
    mx = 0

    for x in range(100000):
        n = search(x, set())
        if n > m:
            m = n
            mx = x
    print(mx, "->", m)

if __name__ == "__main__":
    __main__()
