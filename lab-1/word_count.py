def get_word_count(filename: str, query: str) -> int:
    with open(f"./{filename}.txt","r") as file:
        txt = file.read()
    counter = {}
    txt = txt.replace(".","")
    for word in txt.lower().split():
        counter[word] = counter.get(word,0) + 1
    return counter.get(query,0)

def main() -> int:
    filename = input("Enter the filename: ")
    query = input("Enter the word to query: ")
    print(f"{query} : {get_word_count(filename,query)}")
    return 0
    
if __name__ == "__main__":
    main()