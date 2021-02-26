## Run only in notebooks folder
pip install kaggle --upgrade
cd ../data/
kaggle datasets download -d the-guardian/olympic-games
unzip olympic-games.zip
rm -rf olympic-games.zip
echo -e "\n\nDataset downloaded and extracted: "
ls