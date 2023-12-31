db.shoppingCart.insertMany([{index: NumberInt(1)}, {index: NumberInt(2)}, {index: NumberInt(3)}, {index: NumberInt(4)}, {index: NumberInt(5)}]);

db.getCollection('shoppingCart').find();

db.getCollection('shoppingCart').updateOne(//query
    {index: 1}, //update
    {
        $set: {
            cartId: NumberInt(23), customer: {
                name: "oguz", email: "oasd@fae.com", age: NumberInt(32)
            }, cart: []
        }
    }, //update options (Optional)
    {});

db.getCollection('shoppingCart').updateOne({index: 1}, {
    $unset: {
        cartId: 1, cart: ""
    }
});

db.getCollection('shoppingCart').updateOne({}, {
    $unset: {
        customer: 1
    }
});

db.getCollection('shoppingCart').updateMany({index: 1}, {
    $set: {
        precessed: true
    }
});

db.getCollection('shoppingCart').updateMany({cartId: {$exists: false}}, {
    $currentDate: {
        cDate: true
    }
}, {});

db.getCollection('shoppingCart').replaceOne({index: 1}, {
    index: NumberDecimal(6), proceed: true, cart: ["item1", "item2"]
});

db.getCollection('shoppingCart').replaceOne({index: 6}, {
    cart: NumberDecimal(123)
});//row değerlerinin hepsi verilmeli, aksi halde sadece cart değeri kalır

db.getCollection('shoppingCart').updateMany({index: null}, {
    $set: {
        index: 6
    }
});

db.getCollection('shoppingCart').updateMany({index: 6}, {
    $rename: {
        cart: "orderId"
    }
});

db.getCollection('shoppingCart').updateMany({cart: null}, {
    $currentDate: {
        cart: true
    }
});

db.getCollection('shoppingCart').updateOne({index: 2}, {
    $push: {
        cart: {$each: ["item1", "item2"]}
    }
});

db.getCollection('shoppingCart').updateOne({index: 2}, {
    $addToSet: {
        cart: {$each: ["item1", "item3"]}
    }
});

db.getCollection('shoppingCart').updateOne({index: 2}, {
    $addToSet: {
        cart: ["item9", "item8"]
    }
});

db.getCollection('shoppingCart').updateOne({index: 2}, {
    $pop: {
        cart: -1
    }
});

db.getCollection('shoppingCart').updateOne({index: 3}, {
    $unset: {
        cart: 1
    }
});

db.getCollection('shoppingCart').updateOne({index: 1}, {
    $addToSet: {
        spentAmounts: {
            $each: [NumberInt(100), NumberInt(200), NumberInt(300), NumberInt(400), NumberInt(500)]
        }
    }
});

db.getCollection('shoppingCart').updateOne({index: 1}, {
    $pull: {
        spentAmounts: {$gt: 200}
    }
});//200 üzerini sil

db.getCollection('shoppingCart').updateOne({index: 1}, {
    $pullAll: {
        spentAmounts: [200, 300]
    }
});

db.getCollection('shoppingCart').updateOne({index: 1}, {
    $pull: {
        spentAmounts: {$in: [400, 500]}
    }
});

db.getCollection('shoppingCart').updateMany({index: 2, cart: "item2"}, {
    $set: {
        "cart.$": "dinamik2"
    }
});

db.getCollection('shoppingCart').updateMany({index: 2, cart: "dinamik2"}, {
    $unset: {
        "cart.$": 1
    }
});//dinamik2 is null

db.getCollection('shoppingCart').updateOne({index: 3}, {
    $push: {
        product: [{
            title: "Tr", price: NumberInt(111), quantity: NumberInt(12)
        }, {
            title: "TB", price: NumberInt(999), quantity: NumberInt(1223)
        }]
    }
});

db.getCollection('shoppingCart').updateOne({"product.title": "Tr"}, {
    $set: {
        "product.$.price": NumberInt(77)
    }
});

db.getCollection('shoppingCart').updateMany({product: {$elemMatch: {title: "Tr"}}}, {
    $set: {
        "product.$.quantity": NumberInt(77)
    }
});

db.getCollection('shoppingCart').updateMany({product: {$elemMatch: {title: "Tr"}}}, {
    $inc: {
        "product.$.quantity": NumberInt(100)
    }
});

db.getCollection('shoppingCart').find({}, {product: 1, _id: 0});