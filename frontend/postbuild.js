const path = require('path');
const fs = require("fs-extra");

const env = process.env.GITHUB_WORKSPACE;
console.log('########## env =' + env);
const baseDir = env !== undefined ? env : __dirname;
console.log('########## __dirname =' + __dirname);
const BUILD_DIR = path.join(baseDir, './build');
const PUBLIC_DIR = path.join(baseDir, '../src/main/resources/public');
console.log('########## BUILD_DIR =' + BUILD_DIR);
console.log('########## PUBLIC_DIR =' + PUBLIC_DIR);

fs.emptyDirSync(PUBLIC_DIR);
fs.copySync(BUILD_DIR, PUBLIC_DIR);
