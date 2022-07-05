from bs4 import BeautifulSoup
import requests

# function to extract html document from Codeforces
def getHTMLdocument(url):
  response = requests.get(url)
  return response.text

def getSolvedProblems():
  html_document = getHTMLdocument("https://codeforces.com/submissions/Adxnan10")
  soup = BeautifulSoup(html_document, 'html.parser')
  solved_problems = [] # It will have this format: [ {"Source": "", "When": "" }, {"Source": "", "When": "" }  ]
  problems = soup.table.find_all('tr')
  for problem in problems: 
    if problem.find(class_ ="verdict-accepted"):
      problem_info = problem.find_all(recursive=False)
      problem_object = {
        "solution" : "https://codeforces.com"+ problem_info[0].a['href'], 
        "date" : problem_info[1].getText().strip(),
        "link" : "https://codeforces.com" + problem_info[3].a['href'],
        "name" : problem_info[3].a.getText().strip(),
        "lang" : problem_info[4].getText().strip(),
      }
      solved_problems.append(problem_object)
  return solved_problems

def appendToReadMe():
  solved_problems = getSolvedProblems()
  intro = """
# Codeforces
A repository to keep track of my solutions to problems in Codeforces.
# Solved Problems
| # | Title | Solution | Submitted |
|---| ----- | -------- | --------- |
"""
  with open("README.md", "w") as README:
    README.write(intro)
    for index, problem in enumerate(solved_problems):
      problem_row = f"{index + 1} | [{problem['name']}]({problem['link']}) | [{problem['lang']}]({problem['solution']}) | {problem['date']} |"
      README.write(problem_row + "\n")
      
appendToReadMe()