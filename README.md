# SourceAlliesProject
<B>Description</b><br>
Created repository for the project assignment given by source allies
This project reads the eBook Moby-Dick.txt and returns most frequent word in it which are not present in stopword.txt. 
<br>

<br>
<b>Code Internals</b><br>
To implement it and making sure program doesn't end up having memory overflow, I had used Trie data structure. Trie stores all the words which are not present in stopword.txt and maintains a current count of that word at any given point of time.
TrieWrapper helps me to maintain a list of 100 most frequent word at any given point of time. Once we are done reading the ebook, 100 most frequent word will be in TrieWrapper.
To maintain a list and ease the comparision process a class MostFrequentWordWithFrequency is defined, this class have a word and it's current frequnecy. Sorting can be done on the basis of frequency.

<br>
<br>
<b>To Run it</b><br>
A jar named Moby-Dick Project.jar is created to run this project. One can use commandline to run this project using this jar. Following is the sample commmand:
<br>
java -jar "C:\Users\amod0\Documents\GitHub\SourceAlliesProject\Moby-Dick Project.jar"
<br>
While running this jar make sure that you have mobydick.txt and stopword.txt in the same directory.

Sample Output: <br>
<b>word frquency frequency count</b>
E.g.:<br>
whale frequency 1244
<br>
<br>
<b>Open Issues</b>
1. Unit Test Coverage is pending for few classes.

