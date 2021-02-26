if [ -z "$1" ]
  then
    echo "Please provide a notebook path"
  else
    pip install jupyter_contrib_nbextensions nbconvert==6.0.0
    sudo apt install inkscape texlive-xetex 
    jupyter nbconvert --to pdf $1    
fi

