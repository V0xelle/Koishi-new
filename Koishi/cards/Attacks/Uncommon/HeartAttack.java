/*    */ package Koishi.cards.Attacks.Uncommon;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.actions.HeartAttackAction;
/*    */ import Koishi.cards.AbstractIdCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class HeartAttack
/*    */   extends AbstractIdCard {
/* 15 */   public static final String ID = KoishiMod.makeID(HeartAttack.class.getSimpleName());
/* 16 */   public static final String IMG = KoishiMod.makeCardPath("HeartAttack.png");
/*    */   
/* 18 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 19 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ALL_ENEMY;
/* 20 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.ATTACK;
/* 21 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 2;
/*    */   
/*    */   private static final int DAMAGE = 30;
/*    */   private static final int UPGRADE_PLUS_DMG = 10;
/*    */   
/*    */   public HeartAttack() {
/* 29 */     super(ID, IMG, 2, TYPE, COLOR, RARITY, TARGET);
/* 30 */     this.baseDamage = 30;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 35 */     KoishiMod.runAnimation("downAttack");
/* 36 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new HeartAttackAction(this));
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 41 */     if (!this.upgraded) {
/* 42 */       upgradeName();
/* 43 */       upgradeDamage(10);
/* 44 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Attacks/Uncommon/HeartAttack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */