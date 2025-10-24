## Ques7. There is a file with json format with simple structure. Convert this file into csv format.

_Assumption: "Simple structure" means a file containing one flat JSON object per line like:
{"id": 1, "name": "Alice", "status": "active"}
{"id": 2, "name": "Bob", "status": "pending"}_

#### First, add a header row to a new file 'data.csv'
`echo "id,name,status" > data.csv`

#### Now, process the json and append (>>) it to the csv
`cat data.json | jq -r '[.id, .name, .status] | @csv' >> data.csv`