const path = require('path');
const fs = require("fs-extra");

console.log('########## __dirname =' + __dirname);
const BUILD_DIR = path.join(baseDir, './build');
const PUBLIC_DIR = path.join(baseDir, '../src/main/resources/public');
console.log('########## BUILD_DIR =' + BUILD_DIR);
console.log('########## PUBLIC_DIR =' + PUBLIC_DIR);

fs.emptyDirSync(PUBLIC_DIR);
fs.copySync(BUILD_DIR, PUBLIC_DIR);
