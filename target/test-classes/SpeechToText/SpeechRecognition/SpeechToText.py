# import library
import time
import speech_recognition as sr
import re
# Initialize recognizer class (for recognizing the speech)

r = sr.Recognizer()

# Reading Microphone as source
# listening the speech and store in audio_text variable

with sr.Microphone() as source:
    #print("Talk")
    audio_text = r.listen(source, timeout=10)
    #print("Time over, thanks")
    # recoginize_() method will throw a request error if the API is unreachable, hence using exception handling

    try:
        # using google speech recognition
        #print("Text: " + r.recognize_google(audio_text))
        test_string = r.recognize_google(audio_text)
        #r.recognize_ibm(audio_text)
        temp = re.findall(r'\d+', test_string)
        res = list(map(int, temp))
        print(res[0])
    except:
        print("Sorry, I did not get that")