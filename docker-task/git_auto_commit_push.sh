#!/bin/bash

# Değişkenler
COMMIT_MESSAGE="$1"

# Eğer commit mesajı verilmemişse, hata mesajı yazdır ve çık
if [ -z "$COMMIT_MESSAGE" ]; then
    echo "Kullanım: $0 <commit_message>"
    exit 1
fi

# Değişiklikleri ekle
git add .

# Commit yap
git commit -m "$COMMIT_MESSAGE"

# Push yap
git push

echo "Değişiklikler başarıyla push edildi."
