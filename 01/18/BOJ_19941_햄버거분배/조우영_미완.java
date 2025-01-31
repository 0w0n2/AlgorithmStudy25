// P를 찾았을 때 -k~k까지 순환
// -k가 0보다 작을때와, k가 size()-1보다 작아야하는데 제거 방법?
for(int i=0;i<dinners.size();i++){
    if(dinners.get(i).equals("P")){
        dinners.set(i, (char) 0);

        // i자리에서 -k~k만큼 탐색
        if((i-k)>0 && (i+k)<dinners.size()){
            for(int j=-k;j<=k;j++){
                if(dinners.get(j).equals("H")){
                    dinners.set(j, (char) 0);
                }
            }

        }
    }
}
