echo "Enter the message"
read message

if [ -z "$COMMIT_MESSAGE" ]; then
    echo "Kullanım: $0 <commit_message>"
    exit 1
fi

git add .
git commit -m "$message"
git push