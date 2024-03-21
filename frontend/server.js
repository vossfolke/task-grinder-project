const express = require("express");
const path = require("path");

const app = express();

// any path will bring us to the index html -> single page web app
app.get("/*", (req, res) => {res.sendFile(path.resolve("frontend", "index.html"))} );

app.listen(process.env.PORT || 5060, () => console.log("Server running..."));