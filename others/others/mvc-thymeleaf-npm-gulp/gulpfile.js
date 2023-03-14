var gulp = require('gulp');
var log = require('fancy-log');

gulp.task('greeting', async function () {
	log("**************************");
	log("**************************");
	log("**************************");
	log("Hello World Npm and Gulp!");
	log("**************************");
	log("**************************");
	log("**************************");
});

gulp.task('dev', gulp.series('greeting'));