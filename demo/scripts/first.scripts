db.getCollection('first').insertMany([
    {
        "name": "Mike",
        "friends": [
            {
                "name": "Lora",
                "age": NumberInt(23),
                "registered": true
            },
            {
                "name": "Bob",
                "age": NumberInt(25),
                "registered": false
            },
            {
                "name": "Steve",
                "age": NumberInt(27)
            }
        ]
    },
    {
        "name": "Oguz",
        "friends": [
            {"name": "Lora", "age": NumberInt(23), "registered": true},
            {"name": "Bob", "age": NumberInt(25), "registered": false},
            {"name": "Steve", "age": NumberInt(27)}
        ]
    }
]);

db.getCollection('first').find(
    {"friends.age": {$gt:20 ,$lt:25},
        "friends.name": "Steve" }
    ).count();//less than, greater than

db.getCollection('first').find({friends:{
    "name": "Bob",
        "age": new NumberInt("25"),
        "registered": false}
}).count();//2

db.getCollection('first').find({friends: {
    $elemMatch: {
        "name": "Lora",
        "age" : 23}
    }}).count();//1

db.getCollection('first').find({friends: {
    $exists: true
    }}).count();//2

db.getCollection('first').find({"friends.registered" : {$type:8}}).count();//2

db.getCollection('first').find({},{name:1,_id:0});//only names

db.getCollection('first').find({},{"friends.name": 1,name:1});//names, friends name, _id

db.getCollection('first').find({name: {$regex: /gu/i}});

db.getCollection('first').find({name: {$regex: "o", $options:"i"}});
