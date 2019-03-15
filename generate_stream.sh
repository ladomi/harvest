#!/bin/bash

script_dir=$(cd $(dirname ${BASH_SOURCE:-$0}); pwd)
parent_dir=$(dirname ${script_dir})
script_name=${BASH_SOURCE:-$0}
start_time=$(date +%s)
output_file=result_$(basename ${script_name} .sh)_$(date "+%Y%m%d-%H%M%S").txt

cd ${script_dir}

function check_var () { echo "Variable check: ${1} = $(eval echo \${${1}})"; }

echo "${script_name} started at $(date -d @${start_time} +"%Y/%m/%d %T")"

check_var script_name
check_var script_dir
check_var parent_dir

echo "========================================"

# your process start

# rm -f stream_data.tsv
# touch stream_data.tsv

i=0

while [ $i -lt 1000 ]
do
	id=namioka
	# echo "${id}	$(date "+%Y%m%d%H%M%S%N")	${RANDOM}	${RANDOM}	${RANDOM}" >> stream_data.tsv
	echo "${id},$(date "+%Y%m%d%H%M%S%N"),${RANDOM},${RANDOM},${RANDOM}" >> stream_data.tsv
	# echo "${id}	$(date "+%Y%m%d%H%M%S%N")	${RANDOM}	${RANDOM}	${RANDOM}" | kafka-console-producer --broker-list localhost:9092 --topic test
	# echo "${i}" | kafka-console-producer --broker-list localhost:9092 --topic test
	# sleep 1
	# sleep 0.5
	sleep 0.1
	i=$((i + 1))
	# echo $i
done

echo "elapsed time: $(expr $(date +%s) - ${start_time})"


# your process end

echo "========================================"
end_time=$(date +%s)
elapsed_time=$(expr ${end_time} - ${start_time})
echo "${script_name} ended at $(date -d @${end_time} +"%Y/%m/%d %T")"
echo "elapsed time: ${elapsed_time} sec"

<< commentout
Comment region.
commentout


# utilities

# format json
# cat file.json | python -c 'import sys,json;print(json.dumps(json.loads(sys.stdin.read()),indent=4,ensure_ascii=False))'
