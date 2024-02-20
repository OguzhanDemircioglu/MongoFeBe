db.getCollection('first').getIndexes();

db.getCollection('first').find({"friends.age":{$lt:25}}).explain();

db.getCollection('first').createIndex({age:1},{name:"customAgeElements"});

db.getCollection('first').getIndexes({name:"customAgeElements"});

db.getCollection('first').dropIndex({index:1});

db.getCollection('first').dropIndex({age:1});

db.getCollection('first').dropIndexes();
