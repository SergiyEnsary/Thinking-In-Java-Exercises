package chapter18practices;

/* Modify contol/VowelsAndConsonants.java so that it uses three enum types:
 * VOWEL, SOMETIMES_A_VOWEL, and, CONSONANT. The enum constructor should
 * take the various letters that describe that particular category. Hint: 
 * use varargs, and remember that varargs automatically creates an array
 * for you.
 */

import java.util.*;

public enum Ex5 {
	VOWEL('a', 'e', 'i', 'o', 'u'),
	SOMETIMES_A_VOWEL('w', 'y'),
	CONSONANT('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm',
			'n', 'p', 'q', 'r', 's', 't', 'v', 'x', 'z');
	private Character[] letters;
	private Ex5(Character... letters) {
		this.letters = letters;
	}
	public static Ex5 LetterType(Character c) {
		if(Arrays.asList(VOWEL.letters).contains(c)) return VOWEL;
		if(Arrays.asList(SOMETIMES_A_VOWEL.letters).contains(c)) 
			return SOMETIMES_A_VOWEL;
		return CONSONANT;
	}
	public static void main(String[] args) {
		Random rand = new Random();
		for(int i = 0; i < 100; i++) {
			int c = rand.nextInt(26) + 'a';
			System.out.print((char)c + ", " + c + ": "); 
			System.out.println(LetterType((char)c));			
		}		
	}
}

/*Output:

d, 100: CONSONANT
u, 117: VOWEL
i, 105: VOWEL
z, 122: CONSONANT
v, 118: CONSONANT
q, 113: CONSONANT
z, 122: CONSONANT
b, 98: CONSONANT
f, 102: CONSONANT
d, 100: CONSONANT
o, 111: VOWEL
l, 108: CONSONANT
m, 109: CONSONANT
p, 112: CONSONANT
h, 104: CONSONANT
g, 103: CONSONANT
d, 100: CONSONANT
d, 100: CONSONANT
l, 108: CONSONANT
e, 101: VOWEL
k, 107: CONSONANT
h, 104: CONSONANT
n, 110: CONSONANT
w, 119: SOMETIMES_A_VOWEL
r, 114: CONSONANT
e, 101: VOWEL
f, 102: CONSONANT
c, 99: CONSONANT
q, 113: CONSONANT
b, 98: CONSONANT
v, 118: CONSONANT
i, 105: VOWEL
t, 116: CONSONANT
l, 108: CONSONANT
u, 117: VOWEL
o, 111: VOWEL
a, 97: VOWEL
v, 118: CONSONANT
q, 113: CONSONANT
z, 122: CONSONANT
z, 122: CONSONANT
g, 103: CONSONANT
z, 122: CONSONANT
g, 103: CONSONANT
c, 99: CONSONANT
f, 102: CONSONANT
x, 120: CONSONANT
l, 108: CONSONANT
r, 114: CONSONANT
k, 107: CONSONANT
a, 97: VOWEL
d, 100: CONSONANT
g, 103: CONSONANT
p, 112: CONSONANT
v, 118: CONSONANT
q, 113: CONSONANT
e, 101: VOWEL
c, 99: CONSONANT
m, 109: CONSONANT
v, 118: CONSONANT
p, 112: CONSONANT
t, 116: CONSONANT
t, 116: CONSONANT
j, 106: CONSONANT
s, 115: CONSONANT
p, 112: CONSONANT
a, 97: VOWEL
x, 120: CONSONANT
w, 119: SOMETIMES_A_VOWEL
e, 101: VOWEL
l, 108: CONSONANT
q, 113: CONSONANT
j, 106: CONSONANT
p, 112: CONSONANT
e, 101: VOWEL
q, 113: CONSONANT
s, 115: CONSONANT
b, 98: CONSONANT
x, 120: CONSONANT
j, 106: CONSONANT
d, 100: CONSONANT
e, 101: VOWEL
s, 115: CONSONANT
a, 97: VOWEL
x, 120: CONSONANT
y, 121: SOMETIMES_A_VOWEL
o, 111: VOWEL
q, 113: CONSONANT
j, 106: CONSONANT
r, 114: CONSONANT
p, 112: CONSONANT
n, 110: CONSONANT
v, 118: CONSONANT
d, 100: CONSONANT
m, 109: CONSONANT
c, 99: CONSONANT
o, 111: VOWEL
i, 105: VOWEL
h, 104: CONSONANT
b, 98: CONSONANT

 */