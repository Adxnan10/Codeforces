from bs4 import BeautifulSoup
import requests
from os.path import exists
import re


# function to extract html document from Codeforces
def getHTMLdocument(url):
  response = requests.get(url)
  return response.text

def getSolution(url):
  html_document = getHTMLdocument(url)
  soup = BeautifulSoup(html_document, 'html.parser')
  source = soup.find(id="program-source-text")
  stripped_source = re.sub("\\r", "", source.getText())
  return stripped_source

def importSolution(name, lang, url):
  ext = ".java" # Default extension
  if lang.__contains__("Java"):
    ext = ".java"
  file_exists = exists(f"./solutions/{name + ext}")
  if not file_exists: 
    source_code = getSolution(url)
    source_code_file = open(f"./solutions/{name + ext}","w")
    source_code_file.write(source_code)
    source_code_file.close()

