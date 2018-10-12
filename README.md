This takes in two .csv files and conglomerates them into one with gameplay, speech, and probabilistic data.

To Use:
(Set up format)
mkdir ReadCSV
cd ReadCSV
mkdir data (put your .csv files here)

(Pull project)
git clone https://github.com/jspen14/SpeechCSVScript.git

(Make files)
javac -d bin src/CSVPackage/*.java

(Run project)
java -cp bin CSVPackage.Main data/lRnds.csv data/mProbs.csv data/nOut.csv

Where:
-lRnds.csv is the file that contains game actions, times, and speech acts.
-mProbs.csv is the file that contains probability distributions
-nOut.csv is the name of the desired out file 
