#!C:\Users\zx21student278\AppData\Local\Microsoft\WindowsApps\python

import os
import cgi
import cgitb
cgitb.enable()

form = cgi.FieldStorage()

print("Content-Type: text/html\n")

fileitem = form['filename']

# check if the file has been uploaded
if fileitem.filename:
    # strip the leading path from the file name
    fn = os.path.basename(fileitem.filename)

    # open read and write the file into the server
    open("img/"+fn, 'wb').write(fileitem.file.read())

    print("<img src='img/"+fn+"'>")
