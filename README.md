# Num To String

Solves a classic recreational math problem in two languages. The Python one is faster. Dunno why.

##The problem
Every number has a spoken-English interpretation: 0 is ZERO, 1 is ONE, and so forth.

Every English interpretation has a number representing the number of letters: ZERO -> 4, ONE -> 3, etc.

Are there any numbers which have the same number of letters as its value?

Do all numbers eventually reach this value?

How long does it take to get there?


##The implementation
Each implementation contains two functions: <code>numToString</code> and <code>search</code>.

<code>numToString</code> accepts any integer number and converts it into its spoken form, in allcaps.
For example, <code>numToString(1234)</code> yields "ONE THOUSAND TWO HUNDRED THIRTY FOUR".

<code>search</code> accepts a number and finds how many steps the following pattern takes:
<ol>
<li> Calculate the length (excluding whitespace) of calling <code>numToString</code> on the number.
<li> If the pattern has stabilized (<i>hint: on a certain number</i>), return the number of steps so far.
<li> Else, return <code>search</code> on the new number, incrementing the number of steps.
</ol>

##Future implementations
<ul>
<li>Add decimal numbers
<li>Remove user requirement to add <code>visited</code> on client side
</ul>
