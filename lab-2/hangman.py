from typing import List
import re
from random import choice

def load_wordlist(filename:str) -> List[str]:
    try:
        with open(f"./{filename}","r") as f:
            words = f.readlines()
        assert words is not None or words != []
        return [word.strip("\n") for word in words]
    except AssertionError as ae:
        print(f"Wordlist not populated!")
        print(ae)
        return []
    except FileNotFoundError as fe:
        print(f"File not found!")
        print(fe)
        return []
  
def play_hangman_once(selected_word: str, lives: int=5)-> bool: 
    """Inner loop for the hangman game. Play the game once and return whether player won or lost

    Args:
        selected_word (str): The word to display or check against
        lives (int): The number of lives you start with

    Returns:
        bool: whether the player won or not
    """
    current_guess = re.sub("[A-Za-z0-9]","_",selected_word)
    all_guesses = ""
    
    while current_guess != selected_word:
        
        ## Print the currently known parts of word
        print(f"Currently Known : {current_guess}\n\n")
        
        ## Take the input and append to all guesses string
        all_guesses += str(input("Enter a Guess Character: ")).lower()
        
        ## Logic to find hit/miss and lives updation
        if all_guesses[-1] in selected_word.lower():
            print("\n\nCorrect Guess!\n")
            current_guess = re.sub(f"[^{all_guesses} ]","_",selected_word,flags=re.IGNORECASE)
        elif lives:
            print("\n\nWrong guess!")
            lives -= 1
            print(f"{lives} lives left!\n")
        if not lives:
            print("Out of lives!\n")
            return False
    
    ## If loop is over, the player wins
    return True

def main():
    play_again = True
    words = load_wordlist("words.txt")
    
    while play_again:
        selected_word = choice(words)    
        print("Hurray! You won!" if play_hangman_once(selected_word) else "Bad luck! You lost!")    
        play_again = True if str(input("Play Again? (Y/n): ")).lower() == "y" else False
    
    return 0


if __name__ == "__main__":
    print(f"\n\nProcess exited with return code {main()}")
    