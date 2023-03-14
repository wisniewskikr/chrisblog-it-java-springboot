var gulp = require('gulp'),
	concat = require('gulp-concat'),
	uglify = require('gulp-uglify')
	
paths = {		
		js: [
			'src/main/js/*.js'
		],		
		destJsPath: 'src/main/resources/static/js/',
		destJsName: 'concated.js'
	};	
	
gulp.task('hanldleJs', function() {
	return gulp.src(paths.js)
		.pipe(concat(paths.destJsName))
		.pipe(uglify())
		.pipe(gulp.dest(paths.destJsPath));
});



gulp.task('dev', gulp.series('handleJs'));