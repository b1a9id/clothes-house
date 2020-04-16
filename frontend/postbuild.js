const path = require('path');
const fs = require("fs-extra");

const env = process.env.GITHUB_WORKSPACE;
const baseDir = env.length !== 0 ? env : __dirname;
const BUILD_DIR = path.join(baseDir, './build');
const PUBLIC_DIR = path.join(baseDir, '../src/main/resources/public');

fs.emptyDirSync(PUBLIC_DIR);
fs.copySync(BUILD_DIR, PUBLIC_DIR);
