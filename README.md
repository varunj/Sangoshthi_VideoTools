# Sangoshthi_VideoTools
Android application for project Sangoshthi. To be used for Video Editing and Content Creation


### FFmpeg Commands
ffmpeg -ss 5 -i a.mp4 -t 5 -codec copy temp_a.mp4

ffmpeg -ss 10 -i b.mp4 -t 10 -codec copy temp_b.mp4

echo "file 'temp_a.mp4'" > concat.txt

echo "file 'temp_b.mp4'" >> concat.txt

ffmpeg -f concat -i concat.txt -codec copy output.mp4

rm temp_a.mp4

rm temp_b.mp4

rm concat.txt


### To Discuss

insync: paid 30usd
grive2: manual
overgrive: paid 5usd